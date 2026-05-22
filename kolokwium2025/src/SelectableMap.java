public class SelectableMap
        extends VoivodeshipMap{

    private String selected;


    public void select(
            String voivodeship){

        selected=
                voivodeship;
    }


    protected String getColor(
            String voivodeship){

        if(voivodeship
                .equals(selected)){

            return "red";
        }

        return "lightgray";
    }

}