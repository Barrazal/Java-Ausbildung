// A person under 16 cannot drink beer in Austria
// A person under 18 cannot drink Schnaps in Austria
public class AgeRestriction extends Exception {
    public AgeRestriction(String errorMessage) {
        super(errorMessage);
    }
}
