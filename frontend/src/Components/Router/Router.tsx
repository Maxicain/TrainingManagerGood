import {BrowserRouter, Route, Routes, useParams} from "react-router-dom";
import Villes from "../Villes/Villes";
import Etablissements from "../Etablissement/Etablissements";
import React from "react";

export const AppRouter = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"/"} element={<Villes/>}/>
                <Route path={`/etablissements/:villeId`} element={<Etablissements/>}/>
            </Routes>
        </BrowserRouter>
    )
}

export default AppRouter