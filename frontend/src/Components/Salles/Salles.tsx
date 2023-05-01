import {useEffect, useState} from "react";
import SchoolModel from "../../Model/SchoolModel";
import Presentation = SchoolModel.Presentation;
import {BASE_URL} from "../../App";
import {Link, useParams} from "react-router-dom";

export const Presentations = () => {
    let {etablissementId} = useParams()
    var [presentations, setPresentations] = useState<Presentation[]>([])

    useEffect(() => {(async () => {
        const response = await fetch(BASE_URL + `presentations/${etablissementId}`)
        const json = await response.json()
        json !== null || [] ? setPresentations(json) : setPresentations([])
    })()}, [])

    return(
        <div>
            <h2 className={"display-4 text-center"}>Présentations</h2>
            <div className="d-grid gap-2 col-6 mx-auto">
                {presentations.map((p) =>
                    <Link to={`/${p.id}`} key={p.id} className="btn btn-primary">{p.cours.titre}</Link>)}
            </div>
        </div>
    )
}

export default Presentations