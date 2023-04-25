import { useEffect, useState } from "react"
import { BASE_URL } from "../App"
import SchoolModel from "../Model/SchoolModel";
import Etablissement = SchoolModel.Etablissement;
import {Link, useParams} from "react-router-dom";

export const Etablissements = () => {
    let {villeId} = useParams()
    var [etablissements, setEtablissements] = useState<Etablissement[]>([])

    useEffect(() => {(async () => {
        const response = await fetch(BASE_URL + `etablissements/${villeId}`);
        const json = await response.json();
        json !== null ? setEtablissements(json) : setEtablissements([])
    })()}, [])


    return(
        <div>
            <h2>Établissements</h2>
            <div className="d-grid gap-2 col-6 mx-auto">
                {etablissements.map((e) =>
                <Link to={`/${e.id}`} className="btn btn-primary">{e.nom}</Link>)}
            </div>
        </div>
    )
}

export default Etablissements