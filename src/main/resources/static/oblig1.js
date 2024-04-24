let Bestilling = [];

function BillettBestilling() {
    let film = $('#film').val();
    let antall = $('#antall').val();
    let name = $('#name').val();
    let surname = $('#surname').val();
    let phone = $('#phone').val();
    let email = $('#email').val();
    antall = Number(antall);

    let valid = true;

    if (!film) {
        $('#filmError').html("Velg en film").css("color", "red");
        valid = false;
    } else {
        $('#filmError').html("");
    }

    if (isNaN(antall) || antall <= 0) {
        $('#antallError').html("Må skrive noe inn i antall").css("color", "red");
        valid = false;
    } else {
        $('#antallError').html("");
    }

    if (!name.trim()) {
        $('#nameError').html("Må skrive noe inn i fornavnet").css("color", "red");
        valid = false;
    } else {
        $('#nameError').html("");
    }

    if (!surname.trim()) {
        $('#surnameError').html("Må skirve noe inn i fornavnet").css("color", "red");
        valid = false;
    } else {
        $('#surnameError').html("");
    }

    const phoneRegex = /^\d{8}$/;
    if (!phoneRegex.test(phone.trim())) {
        $('#phoneError').html("Ugyldig Telefonnr").css("color", "red");
        valid = false;
    } else {
        $('#phoneError').html("");
    }

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email.trim())) {
        $('#emailError').html("Ugyldig epostadresse").css("color", "red");
        valid = false;
    } else {
        $('#emailError').html("");
    }

    if (valid) {
        let informasjon = {film, antall, name, surname, phone, email};
        Bestilling.push(informasjon);

        $('#film, #antall, #name, #surname, #phone, #email').val("");

        visBestilling();

        $.post("/billett", informasjon, function (data) {
            visBestilling();
        });
    }
    return valid;

}

function hentAlleBilletter(){
    $.get("/billetter", function (data) {
        visBestilling(data);
    })
}

function visBestilling(data = Bestilling) {
    let ut = "<table><tr><th>Film</th><th>Antall</th><th>Fornavn</th><th>Etternavn</th><th>Telefonnr</th><th>Epost</th></tr>";
    $.each(Bestilling, function(index, B) {
        ut += `<tr><td>${B.film}</td><td>${B.antall}</td><td>${B.name}</td><td>${B.surname}</td><td>${B.phone}</td><td>${B.email}</td></tr>`;
    });
    ut += "</table>";
    $('#alleBilletter').html(ut);
}

function slettBilletter() {
    Bestilling = [];
    visBestilling();
    $.get("/slettBillett", function () {
        hentAlleBilletter()
    })

}
