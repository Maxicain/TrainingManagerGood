import { Link, useLocation } from "react-router-dom";
import {Presentation} from "../SchoolModel";

export const Presentations = () => {
  const location = useLocation();
  const presentations = location.state;

  return (
    <div>
      <h2 className={"display-4 text-center"}>Presentations</h2>
      <br />
      <div className="row">
        {presentations.map((p: Presentation) => (
          <div className="col-md-2 mb-auto mx-auto">
            <div key={p.id} className={"card"} style={{ width: "18rem" }}>
              <div className="card-header">Presentation</div>
              <div className={"card-body"}>
                { p.cours !== null ?
                  <div key={p.cours.id} className={"card"}>
                    <div className="card-header">Course</div>
                    <div className={"card-body"}>
                      <p className={"card-title fs-4"}>{p.cours.titre}</p>
                      <p className={"card-text"}>{p.cours.description}</p>
                      <p className={"card-text text-uppercase fw-bold"}>{p.cours.specialite.titre}</p>
                      <p className={"card-text"}>Credits: {p.cours.nbrCredit}</p>
                      <p className={"card-text"}>Length: {p.cours.duree}h</p>
                    </div>
                  </div> : <p>'Course' data is null.</p> }
                <br/>
                { p.salle !== null ?
                  <div className="card">
                    <div className="card-header">Lecture hall</div>
                    <div className="card-body">
                      <p className={"card-text fs-normal"}>{p.salle.etablissement.titre}</p>
                      <p className={"card-text fw-light fst-italic"}>{p.salle.nom}</p>
                    </div>
                  </div> : <p>'Lecture Hall' data is null.</p> }
                <br/>
                <p className={"card-text"}>Date: {p.date.toString()}</p>
                <p className={"card-text"}>Length: {p.duree}h</p>
                <Link to={`${p.id}/coupons`} className="btn btn-primary" state={p.coupons}>See Coupons</Link>
              </div>
            </div>
          </div>))}
      </div>
    </div>
  );
};

export default Presentations;
