package ibikunle.tolani;

/**
 * Created by tolaniibikunle on 2/8/17.
 */
public class InputValidate {



    public boolean validatePhoneNumber(String phoneNumber){

        boolean valid = (phoneNumber.matches(" ^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$"));
            if( !valid ){ /// if 1
                try {
                    throw new InvalidPhoneNumberFormatException();
                } catch (InvalidPhoneNumberFormatException e) {
                    e.printStackTrace();
                }
              return valid;
            }  // end if 1
        return valid;
    }  /// end validate

}
