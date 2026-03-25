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

        let pu = parseFloat(row.cells[1].querySelector("input")?.value) || 0;
        let qte = parseFloat(row.cells[2].querySelector("input")?.value) || 0;

        let montant = pu * qte;
        row.cells[3].innerText = montant;

        total += montant;
    });

    document.getElementById("total").innerText = total;
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