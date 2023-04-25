import { useEffect, useState } from "react"
import { BASE_URL } from "../App"

export const Etablissements = () => {
    var [etablissements, setEtablissements] = useState<any[]>([])

    useEffect(() => {(async () => {
        const response = await fetch(BASE_URL + "etablissements");
        const json = await response.json();
        setEtablissements(json)
    })()}, [])

    const OnEtablissementClick = () => {

    }

    return(
        <div>
            <h2>Établissements</h2>
            <div className="d-grid gap-2 col-6 mx-auto">
                {etablissements.map((e) => 
                    <button key={e.id} onClick={OnEtablissementClick} className="btn btn-primary">{e.titre}</button>
                    )}
            </div>
        </div>
    )
}

export default Etablissements