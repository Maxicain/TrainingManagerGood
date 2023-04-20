export default class DonutChartModel {
    id: number;
    nom: string;
    Etablissements: []
    constructor (id: number, nom: string, Etablissement: []){
        this.id = id
        this.nom = nom
        this.Etablissements = Etablissement
    }
}