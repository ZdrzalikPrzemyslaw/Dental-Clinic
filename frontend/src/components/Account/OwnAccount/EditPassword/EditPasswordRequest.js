import axios from "axios";
import Cookies from "js-cookie";
import successAlerts from "../../../Alerts/SuccessAlerts/SuccessAlerts";
import errorAlerts from "../../../Alerts/ErrorAlerts/ErrorAlerts";

export function editPasswordRequest(oldPassword, firstPassword, secondPassword, t){
    let token = Cookies.get(process.env.REACT_APP_JWT_TOKEN_COOKIE_NAME);

    let config = {
        method: 'put',
        url: process.env.REACT_APP_BACKEND_URL + "account/new-password",
        headers: {
            'Authorization': 'Bearer ' + token,
            'Content-Type': 'application/json'
        },
        data: {
            oldPassword: oldPassword,
            firstPassword: firstPassword,
            secondPassword: secondPassword
        }
    };

    axios(config)
        .then((response) => {
            successAlerts(t(response.data.message, response.status)).then(() => {
            })
        })
        .catch((response) => {
            if (response.response) {
                errorAlerts(t(response.response.data.message), response.response.status.toString(10));
            }
        });
}
