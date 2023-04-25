import {BrowserRouter, Route, useParams} from "react-router-dom";
import Villes from "./Villes";
import Etablissements from "./Etablissements";
import React from "react";

export const appRouter = () => {
    let {villeId} = useParams()

    return (
        <BrowserRouter>
            <Route path={"/"}>
            <Villes/>
            </Route>
            <Route path={`/etablissements/${villeId}`}>`
                <Etablissements/>
            </Route>
        </BrowserRouter>
    )
}