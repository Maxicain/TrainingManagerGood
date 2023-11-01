import axios from "axios";
import {BASE_URL} from "../../App";
import {useState} from "react";
import {useNavigate} from "react-router-dom";

export const LoginPage = () => {
    const [username, setUsername] = useState<String>("")
    const [password, setPassword] = useState<String>("")
    const navigate = useNavigate()


    const submitLogin = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        axios.post(BASE_URL + "login/auth", {username, password})
            .then( response => {
                const token = response.data.token
                localStorage.setItem("token", token)
                setAuthToken(token)
                navigate("/ville")
            })
            .catch( err => console.log(err))
    }

    return (
        <div>
            <h2 className={"display-4 text-center"}>BetterThanCanvas</h2>
            <h2 className={"display-6 text-center"}>Login</h2>
            <br/>
            <form onSubmit={submitLogin}>
                <div className="form-group col-4 mx-auto">
                    <label className={"control-label fst-italic fw-bold lh-1"}>Username</label>
                    <input type={"text"} onChange={e => setUsername(e.target.value)} placeholder={"Username"} className={"form-control mb-3"}/>
                </div>

                <div className="form-group col-4 mx-auto">
                    <label className={"control-label fst-italic fw-bold lh-1"}>Password</label>
                    <input type={"password"} onChange={e => setPassword(e.target.value)} placeholder={"Password"} className={"form-control mb-3"}/>
                </div>
                <div className="form-group">
                    <input type="submit" value="Login" className="btn btn-primary"/>
                </div>
            </form>
        </div>
    )
}

export const setAuthToken = (token: String) => {
    token ?
        axios.defaults.headers.common["Authorization"] = `Bearer: ${token}` :
        delete axios.defaults.headers.common["Authorization"]
}

export default LoginPage