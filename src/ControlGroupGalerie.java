/**
 * Created by pphelipo on 04/12/15.
 */
public class ControlGroupGalerie {
    ModelGalerie modelGalerie;
    GalerieVue galerieVue;

    public ControlGroupGalerie(ModelGalerie m){
        modelGalerie = m;
        galerieVue = new GalerieVue(modelGalerie);
        ControlButtonGalerie cb = new ControlButtonGalerie(modelGalerie, galerieVue);
    }
}
