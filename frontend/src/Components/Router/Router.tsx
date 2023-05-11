import {BrowserRouter, Route, Routes} from "react-router-dom";
import Villes from "../Villes/Villes";
import Etablissements from "../Etablissement/Etablissements";
import Salles from "../Salles/Salles";
import Presentations from "../Presentations/Presentations";
import Coupons from "../Coupons/Coupons"

export const AppRouter = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"/"} element={<Villes/>}/>
                <Route path={`etablissements/:villeId`} element={<Etablissements/>}/>
                <Route path={`etablissements/:villeId/salles/:etablissementId`} element={<Salles/>}/>
                <Route path={`etablissements/:villeId/salles/:etablissementId/presentations/`} element={<Presentations />}/>
                <Route path={`etablissements/:villeId/salles/:etablissementId/presentations/coupons/:presId`} element={<Coupons />}/>
            </Routes>
        </BrowserRouter>
    )
}

export default AppRouter