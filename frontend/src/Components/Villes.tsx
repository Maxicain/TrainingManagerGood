import { useState, useEffect } from "react";
import { BASE_URL } from "../App";
import SchoolModel from "../Model/SchoolModel";
import {Link} from "react-router-dom";
import Ville = SchoolModel.Ville;

export const Villes = () => {
    var [villes, SetVilles] = useState<Ville[]>([])

    useEffect(() => {(async () => {
        const response = await fetch(BASE_URL + "villes");
        const json = await response.json();
        SetVilles(json)
    })()}, [])

    return(
        <div>
            <h2 className={"display-4 text-center"}>Villes</h2>
            <div className="d-grid gap-2 col-6 mx-auto">
                {villes.map((ville) =>
                <Link to={`etablissements/${ville.id}`} className="btn btn-primary">{ville.nom}</Link>)}
            </div>
        </div>
    )
}

export default Villes 