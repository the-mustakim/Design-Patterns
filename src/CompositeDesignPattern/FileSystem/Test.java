package CompositeDesignPattern.FileSystem;

public class Test {
    public static void main(String[] args) {
        //Let's add a file
        FileSystem hulchul = new File("hulchul.mp4");
        FileSystem haunted = new File("Haunted.mp4");

        //Let's add a directory
        Directory movies = new Directory("Movies");
        Directory comedyMovies = new Directory("comedyMovies");
        Directory horrorMovies = new Directory("horrorMovies");

        movies.addInFileSystem(comedyMovies);
        movies.addInFileSystem(horrorMovies);

        comedyMovies.addInFileSystem(hulchul);
        horrorMovies.addInFileSystem(haunted);

        comedyMovies.ls();
    }
}
