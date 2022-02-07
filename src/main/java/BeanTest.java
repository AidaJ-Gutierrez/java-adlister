public class BeanTest {

    public static void main(String[] args) {
        Album album = new Album(1, "Taylor Swift", "Evermore", 2020, 42, "Pop" );
        Author author = new Author(1, "Albert", "Einstein");
        Quote quote = new Quote(1, "Albert Einstein","Anyone who has never made a mistake has never tried enything new");


        System.out.printf(album.getArtist(), album.getName());
        System.out.println(author.getLastName());
        System.out.println(quote.getContent());


    }
}
