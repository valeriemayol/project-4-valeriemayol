import java.util.Comparator;
//This class compares Total Gross in a numerical attribute
public class CompareTotalGross implements Comparator<DisneyMovie> {
    public int compare(DisneyMovie a, DisneyMovie b){
        if (a.getTotalGross() != b.getTotalGross()){
            return a.getTotalGross() - b.getTotalGross(); //Returns Total Gross Income in order

        }
        else {
            return(a.getInflation() - b.getInflation());//If for some reason there is a tie; goes to inflation adjusted gross income
        }
    }
}
