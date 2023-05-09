import {BrowserRouter, Route, Routes} from "react-router-dom";
import Villes from "../Villes/Villes";
import Etablissements from "../Etablissement/Etablissements";
import Salles from "../Salles/Salles";
import Presentations from "../Presentations/Presentations";

export const AppRouter = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"/"} element={<Villes/>}/>
                <Route path={`/etablissements/:villeId`} element={<Etablissements/>}/>
                <Route path={`/salles/:etablissementId`} element={<Salles/>}/>
                <Route path={`/presentations/:salleId`} element={<Presentations />}/>
            </Routes>
        </BrowserRouter>
    )
}

export default AppRouter