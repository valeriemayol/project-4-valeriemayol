public class DisneyMovie implements Comparable <DisneyMovie>{

    private String movieName;
    private String Releasedate;
    private String genre;
    private String rating;
    private int totalGross;
    private int inflation;

    //default constructor
    public DisneyMovie(){
      super();
    }
    // constructor
    public DisneyMovie(DisneyMovie movies){
        super();
        this.movieName = movies.getMovieName();
        this.Releasedate = movies.getReleasedate();
        this.genre = movies.getGenre();
        this.rating = movies.getRating();
        this.totalGross = movies.getTotalGross();
        this.inflation = movies.getInflation();
    }

    public DisneyMovie(String name, String date, String genre, String rate, int income, int inflation){
        this.movieName = name;
        this.Releasedate = date;
        this.genre = genre;
        this.rating = rate;
        this.totalGross = income;
        this.inflation = inflation;
    }
    //Makes string version of information
    @Override
    public String toString() {
        String DisneyInfo;
        DisneyInfo = movieName + "had $" + totalGross + " Gross Income"; //Prints movie name and it's Total Gross Income
            return DisneyInfo;
    }

    //getters
    public String getMovieName() { return movieName;}

    public String getReleasedate() { return Releasedate;}

    public String getGenre() { return genre; }

    public String getRating() { return rating;}

    public int getTotalGross(){ return totalGross;}

    public int getInflation(){ return inflation;}

    @Override
    public int compareTo(DisneyMovie o) {
        return Integer.compare(getTotalGross(), o.getTotalGross());
    }
}
