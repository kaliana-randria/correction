let index = 1;

function ajoutLigne() {
    let table = document.getElementById("detailsTable");

    let row = table.insertRow();

    row.innerHTML = `
        <td><input name="details[${index}].libelle"></td>
        <td><input type="number" name="details[${index}].PU" oninput="calcul()" min="1"></td>
        <td><input type="number" name="details[${index}].qtte" oninput="calcul()" min="1"></td>
        <td class="montant">0</td>
        <td><button type="button" onclick="supprimerLigne(this)">Supprimer</button></td>
    `;

    index++;
}

function calcul() {
    let total = 0;

    document.querySelectorAll("#detailsTable tr").forEach((row, i) => {
        if (i === 0) return;

        const inputPu = row.cells[1].querySelector("input");
        const inputQte = row.cells[2].querySelector("input");

        let pu = parseFloat(inputPu.value) || 0;
        let qte = parseFloat(inputQte.value) || 0;

        let puFinal = pu;

        if (pu >= REDUCTION) {
            puFinal = pu - ((pu * 10)/100);
            // inputPu.value = puFinal;
        }

        let montant = puFinal * qte;

        row.cells[3].innerText = montant.toLocaleString();

        total += montant;
    });

    document.getElementById("total").innerText = total.toLocaleString();
}


function supprimerLigne(btn) {
    let table = document.getElementById("detailsTable");

    if (table.rows.length <= 2) { 
        alert("Au moins une ligne est obligatoire !");
        return;
    }

    let row = btn.closest("tr");
    row.remove();

    calcul();
}