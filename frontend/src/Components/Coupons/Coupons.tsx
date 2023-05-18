import {Link, useLocation} from "react-router-dom";
import SchoolModel from "../../Model/SchoolModel";
import Coupon = SchoolModel.Coupon;

export const Coupons = () => {
    const location = useLocation();
    const coupons = location.state;

    return(
        <div>
            <h2 className={"display-4 text-center"}>Coupons</h2>
            <br/>
            <div className={"row row-cols-5 gy-2"}>
            {coupons.map((c: Coupon) => (
                !c.reserve ?
                <div key={c.id} className={"col gx-5"}>
                    <div className={"card"}>
                        <Link to={`${c.id}/reserver`} state={c} className={"card-body btn btn-primary "}>
                            <p className={"text-white"}>{c.place.position}</p>
                            <p className={"text-white"}>${c.tarif.toFixed(2)}</p>
                        </Link>
                    </div>
                </div> :
                <div key={c.id} className={"col gx-5"}>
                    <div className={"card text-bg-secondary"}>
                        <div className={"card-body disabled text-white"}>
                            <p className={"text-white"}>{c.place.position}</p>
                            <p className={"text-white"}>{c.nomClient}</p>
                        </div>
                    </div>
                </div>
            ))}
            </div>
        </div>
    )
}

export default Coupons