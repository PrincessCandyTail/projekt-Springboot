
const API_URL = 'http://localhost:8080/api';

export async function fetchKunden() {
    const res = await fetch(`${API_URL}/kunden`);
    return res.json();
}

export async function fetchPolicen() {
    const res = await fetch(`${API_URL}/police`);
    return res.json();
}

export async function fetchZahlungen() {
    const res = await fetch(`${API_URL}/zahlungen`);
    return res.json();
}

export async function fetchVersicherungsarten() {
    const res = await fetch(`${API_URL}/versicherungsarten`);
    return res.json();
}

export async function fetchArbeiter() {
    const res = await fetch(`${API_URL}/arbeiter`);
    return res.json();
}
