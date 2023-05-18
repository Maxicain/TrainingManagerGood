import React from 'react';
import {Route, Routes} from 'react-router-dom';
import {LoginPage} from "../Authentication";

interface ParentCompProps {
    childComp?: React.ReactNode;
}

const RouteGuard: React.FC<ParentCompProps> = (props) => {
    const { childComp } = props;
    function hasJWT() {
        return localStorage.getItem("token") ? true : false
    }

    return (
        <Routes> 
            <Route element={
                hasJWT() ?
                    childComp :
                    <Route path={"/login"} element={<LoginPage/>}/>
            }/>
        </Routes>
    );
};

export default RouteGuard;