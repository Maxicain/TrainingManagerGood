import { useLocation } from "react-router-dom";
import SchoolModel from "../../Model/SchoolModel";
import Coupon = SchoolModel.Coupon;

export const Coupons = () => {
    const location = useLocation();
    const coupons = location.state;
    
    console.log(coupons)
    return(
        <div>
            <h2>Coupons</h2>
            <br/>
            <div>
            {coupons.map((c: Coupon) => (
                <p>{c.reserve}</p>
            ))}
            </div>
        </div>
    )
}

export default Coupons