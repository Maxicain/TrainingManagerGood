import {BASE_URL} from "../../App";
import {useLocation} from "react-router-dom";
import SchoolModel from "../../Model/SchoolModel";
import Coupon = SchoolModel.Coupon
import {FormEvent, useState} from "react";
import {JsogService} from "jsog-typescript";
import axios from "axios";

export const ReserveForm = () => {
    const location = useLocation();
    const couponHeld = location.state;
    const jsog = new JsogService()

    const [coupon, setCoupon] = useState<Coupon>(couponHeld)
    const [nomClient, setNomClient] = useState<string>("")
    const [formSubmitted, setFormSubmitted] = useState(false);

    const submitReservation = async (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault()

        coupon.reserve = !(coupon.reserve)
        coupon.nomClient = nomClient

        await axios.put(BASE_URL + `reserve/${coupon.id}`, jsog.serialize(coupon))
            .then(response => setCoupon(response.data))
            .catch( error => console.log(error))
            .finally(() =>  {
                alert("Votre coupon a été réservé sous le nom de " + coupon.nomClient)
                setFormSubmitted(true)
            })
    }

    return (
        <div>
            <h2 className={"display-4 text-center"}>Reserve your place</h2>
            <br/>
            <form onSubmit={submitReservation}>
                <div className="form-group col-4 mx-auto">
                    <label className={"control-label fst-italic fw-bold lh-1"}>Quel est le nom du déteneur du coupon?</label>
                    <input type={"text"} onChange={e => setNomClient(e.target.value)} placeholder={"Nom"} className={"form-control mb-3"}/>
                </div>
                <div className="form-group">
                    <input type="submit" value="Réserver" className="btn btn-primary"/>
                </div>
            </form>
            {formSubmitted && (
                <div>
                    <br/>
                    <p>Votre code de paiement est: {coupon.codePaiement}.</p>
                    <p className={"fw-bold"}>Gardez le précieusement!</p>
                </div>
            )}
        </div>
    )
}

export default ReserveForm