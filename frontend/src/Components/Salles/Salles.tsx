import {useEffect, useState} from "react";
import SchoolModel from "../../Model/SchoolModel";
import Salle = SchoolModel.Salle
import {BASE_URL} from "../../App";
import {Link, useParams} from "react-router-dom";
import {JsogService} from "jsog-typescript";

export const Salles = () => {
    let {etabId}  = useParams()
    let [salles, setSalles] = useState<Salle[]>([])
    const jsog = new JsogService()

    useEffect(() => {(async () => {
        await fetch(BASE_URL + `salle/${etabId}`)
            .then(response => response.json())
            .then(data => {
                data = jsog.deserialize(data)
                setSalles(data)
            })
    })()}, [etabId])

    return(
        <div>
            <h2 className={"display-4 text-center"}>Salles</h2>
            <br/>
            <div className="d-grid gap-2 col-6 mx-auto">
                {salles.map((s) =>
                    <div key={s.id}>
                        <p className={"fw-normal lh-1"}>{s.etablissement.titre}</p>
                        <p className={"fw-light fst-italic lh-1"}>{s.nom}</p>
                        <Link to={`presentations`} key={s.id} className="btn btn-primary" state={s.presentations}>Voir présentations</Link>
                        <br/>
                        <br/>
                    </div>
                )}
            </div>
        </div>
    )
}

export default Salles