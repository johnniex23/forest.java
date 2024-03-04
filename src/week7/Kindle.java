package week7;

public class Kindle {

  private int totalPages;
  private int currentPage;


  // constructor
public Kindle(int totalPages) {

    this.totalPages=totalPages;
  currentPage=1;

} // end of constructor


    // toString method
public String toString () {

 return "Pages   " + currentPage + " of  " +totalPages+".";

} // end of toString method


     // no argument increaseCurrentPage method
    public void turnPages() {

    int page= currentPage+1;

    if (page > totalPages) {

        System.out.println("Turning 1 pages would take you past the last page");


    }
    currentPage++;

    }


    // argument increaseCurrentPage method
        public void turnPages(int increasedPages) {

            int page= this.currentPage+increasedPages;

            if (page > totalPages) {

                System.out.println("Turning " + increasedPages+" pages would take you past the last page.");
                currentPage=totalPages;

            }
                else {
                this.currentPage = increasedPages +  this.currentPage ;

            }



        } // end of increaseCurrentPage





} // end of Kindle class
