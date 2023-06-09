import {BrowserRouter, Route, Routes} from "react-router-dom";
import {Villes} from "../Villes";
import {Etablissements} from "../Etablissement";
import {Salles} from "../Salles";
import {Presentations} from "../Presentations";
import {Coupons} from "../Coupons"
import {ReserveForm} from "../Reserve";
import LoginPage from "../Authentication/LoginPage";
import RouteGuard from "./RouteGuard";


export const AppRouter = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"*"} element={<RouteGuard childComp={<Villes/>}/>}/>
                <Route path={"/"} element={<LoginPage/>}/>
                <Route path={`/ville`} element={<Villes/>}/>
                <Route path={`/ville/:villeId/etablissements`} element={<Etablissements/>}/>
                <Route path={`/ville/:villeId/etablissements/:etabId/salles`} element={<Salles/>}/>
                <Route path={`/ville/:villeId/etablissements/:etabId/salles/presentations/`} element={<Presentations />}/>
                <Route path={`/ville/:villeId/etablissements/:etabId/salles/presentations/:presId/coupons`} element={<Coupons />}/>
                <Route path={`/ville/:villeId/etablissements/:etabId/salles/presentations/:presId/coupons/:couponId/reserver`} element={<ReserveForm />}/>
            </Routes>
        </BrowserRouter>
    )
}

export default AppRouter