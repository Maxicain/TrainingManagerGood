export namespace SchoolModel{
    export interface Ville {
        id: number
        nom: string
        etablissements: [Etablissement]
    }

    export interface Etablissement {
        id: number
        titre: string
        ville: Ville
    }

    export interface Salle {
        id: number
        nom: string
        etablissement: Etablissement
        presentations: [Presentation]
    }

    export interface Cours{
        id: number
        titre: string
        description: string
        nbrCredit: number
        duree: number
        presentations: [Presentation]
        specialite: Specialite
    }

    export interface Presentation{
        id: number
        date: Date
        duree: number
        cours: Cours
        salle: Salle
        sceance: Sceance
        coupons: [Coupon]
    }

    export interface Place{
        id: number
        position: string
        salle: Salle
        coupon: Coupon
    }

    export interface Sceance{
        id: number
        heureDebut: string
        presentation: Presentation
    }

    export interface Specialite{
        id: number
        titre: string
        cours: [Cours]
    }

    export interface Coupon{
        id: number
        nomClient: string
        tarif: number
        codePaiement: string
        reserve: boolean
        presentation: Presentation
        place: Place
    }
}

export default SchoolModel