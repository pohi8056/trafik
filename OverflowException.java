public class OverflowException extends RuntimeException {
    
    public OverflowException(){
	super();
    }

    public OverflowException(String s){
	super(s);
    }
    // Undantag som kastas nar det inte gick att lagga 
    // in en ny bil pa vagen
}
