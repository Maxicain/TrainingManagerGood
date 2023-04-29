import { useEffect, useState } from "react"
import { BASE_URL } from "../App"
import SchoolModel from "../Model/SchoolModel";
import Etablissement = SchoolModel.Etablissement;
import {Link, useParams} from "react-router-dom";

export const Etablissements = () => {
    let {villeId} = useParams()
    var [etablissements, setEtablissements] = useState<Etablissement[]>([])

    useEffect(() => {(async () => {
        const response = await fetch(BASE_URL + `etablissement/${villeId}`)
        const json = await response.json();
        console.log(json)
        json !== null || [] ? setEtablissements(json) : setEtablissements([])
    })()}, [])

    console.log(etablissements)
    return(
        <div>
            <h2 className={"display-4 text-center"}>Établissements</h2>
            <div className="d-grid gap-2 col-6 mx-auto">
                {etablissements.map((e) =>
                    <Link to={`/${e.id}`} key={e.id} className="btn btn-primary">{e.titre}</Link>)}
            </div>
        </div>
    )
}

export default Etablissements