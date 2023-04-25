export namespace SchoolModel{
    export interface Ville {
        id: number
        nom: string
        etablissements: [Etablissement]
    }

    export interface Etablissement {
        id: number
        nom: string
        ville: Ville
    }

    interface Salle {
        id: number
        nom: string
        etablissement: Etablissement
        presentations: [Presentation]
    }

    interface Cours{
        id: number
        titre: string
        description: string
        nbrCredit: number
        duree: number
        presentations: [Presentation]
    }

    interface Presentation{
        id: number
        date: Date
        duree: number
        cours: Cours
        salle: Salle
        sceance: Sceance
        coupons: [Coupon]
    }

    interface Place{
        id: number
        position: string
        salle: Salle
        coupon: Coupon
    }

    interface Sceance{
        id: number
        heureDebut: string
        presentation: Presentation
    }

    interface Specialite{
        id: number
        titre: string
        cours: [Cours]
    }

    interface Coupon{
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