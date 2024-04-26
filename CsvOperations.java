public class CsvOperations {

    public String toSvg() {
        String code = "\n";
        code += "\t";
        code += "<polygon points=\"";
        for (Vec2 p : points){
            code += p.getX() + "," + p.getY() + " ";
        }
        code += "\"";
        code += getStyle().toSvg() + "/>";
        code += "\n";
        return  code;
    }
}
public static List<Person> fromCsvFile(String filePath) {
    List<Person> people = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            fromCsvLine(line, people);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return people;
}
public static void fromCsvLine(String csvLine, List<Person> people) {
    try {
        String[] parts = csvLine.split(",");
        LocalDate birthDate = null;
        LocalDate deathDate = null;
        Person mother = null;
        Person father = null;
        String fullName = null;
        int numOfColumns = parts.length;
        if (numOfColumns > 0){
            fullName = parts[0].trim();
        }
        if (numOfColumns > 1){
            birthDate = LocalDate.parse(parts[1].trim(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        if (numOfColumns > 2 && !parts[2].trim().isEmpty()) {
            deathDate = LocalDate.parse(parts[2].trim(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
        if (numOfColumns > 3) {
            String motherFullName = parts[3].trim();
            mother = find(motherFullName, people);
            if (mother == null && !motherFullName.isEmpty()){
                mother = new Person(fullName);
            }
            mother = verifyParent(mother, birthDate, motherFullName, fullName);
        }
        if (numOfColumns > 4){
            String fatherFullName = parts[4].trim();
            father = find(fatherFullName, people);
            if (father == null && !fatherFullName.isEmpty()){
                father = new Person(fullName);
            }
            father = verifyParent(father, birthDate, fatherFullName, fullName);
        }
        if (deathDate != null && deathDate.isBefore(birthDate))
            throw new NegativeLifespanException(fullName);
        Person personToAdd = find(fullName, people);
        if (isPersonOnTheList(personToAdd, people))
            throw new AmbigiousPersonException(personToAdd.getFullName());
        if (personToAdd == null){
            personToAdd = new Person(fullName, birthDate, deathDate, mother, father);
        }else {
            personToAdd.birthDate = birthDate;
            personToAdd.deathDate = deathDate;
            personToAdd.mother = mother;
            personToAdd.father = father;
        }
        people.add(personToAdd);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}