class StringCalculator {

       static int add(String numbers) throws Exception {
        int res = 0 ;

        if(numbers.equals(""))
            return 0;

        String regexDelimiter = numbers.substring(0,4);
        String personalisedDelimiter = buildPersonalisedDelimiter(regexDelimiter);
        String[] aSplitString =  splitNumbersString(numbers, personalisedDelimiter);
        String errorMessage = "Les nombres négatifs ne sont pas autorisés :";

        for(int i=0; i<aSplitString.length; i++) {
            if(Integer.valueOf(aSplitString[i])<0) {
                errorMessage+= " " + Integer.valueOf(aSplitString[i]);
            }
            else if(Integer.valueOf(aSplitString[i])>1000){
                //skip those numbers
            }
            else {
                res += Integer.valueOf(aSplitString[i]);
            }
        }

        if(!errorMessage.equals("Les nombres négatifs ne sont pas autorisés :"))
            throw new Exception(errorMessage);

        return res;

    }

    private static String[] splitNumbersString(String numbers, String personalisedDelimiter){
        String[] aSplitString;
        if(!personalisedDelimiter.equals(""))
            aSplitString = numbers.substring(4).split(",+|\n+|" + personalisedDelimiter + "+");
        else
            aSplitString = numbers.split(",+|\n+");
        return aSplitString;
    }

    private static String buildPersonalisedDelimiter(String regexDelimiter){
        if(!regexDelimiter.matches("\\/\\/.\n"))
            return "";

        return String.valueOf(regexDelimiter.charAt(regexDelimiter.length()-2));
    }


}
