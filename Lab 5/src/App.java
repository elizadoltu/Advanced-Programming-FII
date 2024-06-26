
public class App {
    public static void main(String[] args) throws Exception {
        String masterDirectoryPath = "C:/Users/Admin/Desktop/Proiecte/Facultate/Advanced Programming/Advanced-Programming-FII/Doltu_1234";                                                                                                // path

        try {
            Repository repository = new Repository(masterDirectoryPath);

            // Display the directory and its contents
            System.out.println("Master Directory: " + repository.getDirectory());
            System.out.println("Repository Contents:");
            for (Person person : repository.getDocuments().keySet()) {
                System.out.println("Person: " + person.name() + ", ID: " + person.id());
                System.out.println("Documents:");
                for (Document document : repository.getDocuments().get(person)) {
                    System.out.println("  Name: " + document.name() + ", Format: " + document.format());
                }
                System.out.println();
            }

        } catch (InvalidRepository e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
