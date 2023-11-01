export type Ville = {
    id: number
    nom: string
    etablissements: [Etablissement]
}

export type Etablissement = {
    id: number
    titre: string
    ville: Ville
}

export type Salle = {
    id: number
    nom: string
    etablissement: Etablissement
    presentations: [Presentation]
}

export type Cours = {
    id: number
    titre: string
    description: string
    nbrCredit: number
    duree: number
    presentations: [Presentation]
    specialite: Specialite
}

export type Presentation = {
    id: number
    date: Date
    duree: number
    cours: Cours
    salle: Salle
    sceance: Sceance
    coupons: [Coupon]
}

export type Place = {
    id: number
    position: string
    salle: Salle
    coupon: Coupon
}

export type Sceance = {
    id: number
    heureDebut: string
    presentation: Presentation
}

export type Specialite = {
    id: number
    titre: string
    cours: [Cours]
}

export type Coupon = {
    id: number
    nomClient: string
    tarif: number
    codePaiement: string
    reserve: boolean
    presentation: Presentation
    place: Place
}