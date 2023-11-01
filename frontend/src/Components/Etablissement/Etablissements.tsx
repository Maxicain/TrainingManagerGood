import { useEffect, useState } from "react"
import { BASE_URL } from "../../App"
import SchoolModel from "../../Model/SchoolModel"
import Etablissement = SchoolModel.Etablissement
import {Link, useParams} from "react-router-dom"
import axios from "axios";

export const Etablissements = () => {
    let {villeId} = useParams()
    var [etablissements, setEtablissements] = useState<Etablissement[]>([])

    useEffect(() => {(async () => {
        await axios.get(BASE_URL + `etablissement/${villeId}`)
            .then(response => setEtablissements(response.data))
            .catch(err => console.log(err))
    })()}, [villeId])

    return(
        <div>
            <h2 className={"display-4 text-center"}>Establishments</h2>
            <div className="d-grid gap-2 col-6 mx-auto">
                {etablissements.map((e) =>
                    <Link to={`${e.id}/salles`} key={e.id} className="btn btn-primary">{e.titre}</Link>)}
            </div>
        </div>
    )
}

export default Etablissements