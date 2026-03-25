document.addEventListener("DOMContentLoaded", function () {

    document.getElementById("idDemande").addEventListener("blur", function () {
        let id = this.value;

        fetch("/devis/demande/" + id)
            .then(res => {
                if (!res.ok) throw new Error();
                return res.json();
            })
            .then(data => {
                document.getElementById("infoDemande").innerHTML =
                    " Client: " + data.client.nom + " | Lieu: " + data.lieu + " | District: " + data.district + " | Date: " + data.date;
            })
            .catch(() => {
                document.getElementById("infoDemande").innerHTML =
                    "<span style='color:red'>Demande introuvable</span>";
            });
    });

});