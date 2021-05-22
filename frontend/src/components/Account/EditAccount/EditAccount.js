import React, { Component, Suspense } from 'react';
import { withTranslation } from 'react-i18next';
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import "./EditAccount.css";
import axios from "axios";
import {editAccountRequest} from "./EditAccountRequest";
import {useTranslation} from "react-i18next";

class EditAccountWithoutTranslation extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            // translation: useTranslation(),
            isDisabled: true,
            text: "Edit",
            login: "",
            email: "",
            firstName: "",
            lastName: "",
            phoneNumber: "",
            pesel: "",
        }
    }

    componentDidMount() {
        axios
            .get(process.env.REACT_APP_BACKEND_URL + "account/info", {
                headers: {
                    Authorization: "Bearer " + localStorage.getItem("JWTToken")
                }
            })
            .then(res => res.data)
            .then(result => this.setState({
                login: result.login,
                email: result.email,
                firstName: result.firstName,
                lastName: result.lastName,
                phoneNumber: result.phoneNumber,
                pesel: result.pesel
            }))
    }

    validateForm(t) {
        // Todo: zrobić walidację taką jaką wymaga projekt

        function emailCorrect() {
            return t.state.email.length > 0;
        }

        function firstNameCorrect() {
            return t.state.firstName.length > 0;
        }

        function lastNameCorrect() {
            return t.state.lastName.length > 0;
        }

        function phoneNumberCorrect() {
            return true;
            // return t.state.phoneNumber.length > 0 && /^\d+$/.test(t.state.phoneNumber);
        }

        // TODO: przypadek obcokrajowca wymusza że peselu może nie być ale nadal warto by go zwalidowac, tylko jak?
        function peselCorrect() {
            return true;
        }

        return emailCorrect() && firstNameCorrect() && lastNameCorrect() && phoneNumberCorrect() && peselCorrect();
    }


    // Todo: prawdopodobnie wysyłać zapytanie do backendu tutaj, chciałbym zrobić tak jak w vue się da żeby jeśli odpalam w trybie debug front to łącze z localhostem, narazie nie ruszam.
    handleSubmit(event) {
        event.preventDefault();
    }

    handleOnClick(t) {
        if (this.state.isDisabled === true) {
            this.setEditable()
        } else {
            this.setNotEditable(t)
        }
    }

    setEditable() {
        this.setState({
            isDisabled: false,
            text: useTranslation("Save")
        });
    }

    setNotEditable(t) {
        this.validateForm(t)
        this.setState({
            isDisabled: true,
            text: useTranslation("Edit")
        });
        editAccountRequest(this.state.login, this.state.email, this.state.firstName, this.state.lastName, this.state.phoneNumber, this.state.pesel)
    }

    // todo: Czy dodawać tutaj też język do wyboru z en / pl? W dto go nie ma
    render() {
        const { t } = this.props;

        return (
            <div className="EditAccount">
                <Form onSubmit={this.handleSubmit}>
                    <Form.Group size="lg" controlId="login">
                        <Form.Label>{t("UserLogin")}</Form.Label>
                        <Form.Control
                            autoFocus
                            type="login"
                            value={this.state.login}
                            disabled={true}
                            onChange={(e) => this.setState({login: e.target.value})}
                        />
                    </Form.Group>
                    <Form.Group size="lg" controlId="email">
                        <Form.Label>{t("Email")}</Form.Label>
                        <Form.Control
                            autoFocus
                            type="email"
                            value={this.state.email}
                            disabled={this.state.isDisabled}
                            onChange={(e) => this.setState({email: e.target.value})}
                        />
                    </Form.Group>
                    <Form.Group size="lg" controlId="firstName">
                        <Form.Label>{t("First Name")}</Form.Label>
                        <Form.Control
                            type="text"
                            value={this.state.firstName}
                            disabled={this.state.isDisabled}
                            onChange={(e) => this.setState({firstName: e.target.value})}
                        />
                    </Form.Group>
                    <Form.Group size="lg" controlId="lastName">
                        <Form.Label>{t("Last Name")}</Form.Label>
                        <Form.Control
                            type="text"
                            value={this.state.lastName}
                            disabled={this.state.isDisabled}
                            onChange={(e) => this.setState({lastName: e.target.value})}
                        />
                    </Form.Group>
                    <Form.Group size="lg" controlId="phoneNumber">
                        <Form.Label>{t("Phone Number")}</Form.Label>
                        <Form.Control
                            type="text"
                            value={this.state.phoneNumber}
                            disabled={this.state.isDisabled}
                            onChange={(e) => this.setState({phoneNumber: e.target.value})}
                        />
                    </Form.Group>
                    {/*Todo: co z peselem dla obcokrajowca? Nic czy coś innnego? Narazie zrobiłem że może być pusty*/}
                    <Form.Group size="lg" controlId="pesel">
                        <Form.Label>{t("Pesel")}</Form.Label>
                        <Form.Control
                            type="text"
                            value={this.state.pesel}
                            disabled={this.state.isDisabled}
                            onChange={(e) => this.setState({pesel: e.target.value})}
                        />
                    </Form.Group>
                    <Button block size="lg" type="submit"
                            onClick={() => this.handleOnClick(this)}>
                        {this.state.text}
                    </Button>
                </Form>
            </div>
        );
    }
}


const EditAccountTr = withTranslation()(EditAccountWithoutTranslation)

export default function EditAccount() {
    return (
        <Suspense fallback="loading">
            <EditAccountTr />
        </Suspense>
    );
}
