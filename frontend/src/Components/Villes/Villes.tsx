import { useState, useEffect } from "react"
import { BASE_URL } from "../../App"
import SchoolModel  from "../../Model/SchoolModel"
import Ville = SchoolModel.Ville
import { Link } from "react-router-dom"
import axios from "axios"   

export const Villes = () => {
    var [villes, setVilles] = useState<Ville[]>([])

    useEffect(() => {(async () => {
        await axios.get(BASE_URL + "villes", {headers:{
            Authorization: `Bearer ${localStorage.getItem("token")}`
        }})
            .then(response => setVilles(response.data))
            .catch(err => console.log(err))
    })()}, [])

    return(
        <div>
            <h2 className={"display-4 text-center"}>Cities</h2>
            <div className="d-grid gap-2 col-6 mx-auto">
                {villes.map((ville) =>
                <Link to={`/ville/${ville.id}/etablissements`} key={ville.id} className="btn btn-primary">{ville.nom}</Link>)}
            </div>
        </div>
    )
}

export default Villes