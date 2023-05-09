import {Key, useEffect, useState} from "react";
import SchoolModel from "../../Model/SchoolModel";
import Presentation = SchoolModel.Presentation;
import {BASE_URL} from "../../App";
import {Link, useLocation, useParams} from "react-router-dom";

export const Presentations = () => {
    const location = useLocation()
    const presentations = location.state

    return (
        <div>
            <h2 className={"display-4 text-center"}>Présentations</h2>
            <br/>
            <div className="d-grid gap-2 col-6 mx-auto">
                {presentations.map((p: Presentation) =>
                    <p>{p.duree}</p>
                    // <Link to={`/presentations/${p.id}`} key={p.id} className="btn btn-primary">Voir présentations</Link>
                )}
            </div>
        </div>
    )
}

export default Presentations