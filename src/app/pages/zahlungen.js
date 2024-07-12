'use client'
import {fetchZahlungen} from "@/app/pages/api";

export async function getServerSideProps() {
    const zahlungen = await fetchZahlungen();
    return { props: { zahlungen } };
}

export default function Zahlungen({ zahlungen }) {
    return (
        <div>
            <h1>Zahlungen</h1>
            <ul>
                {zahlungen.map((zahlung) => (
                    <li key={zahlung.id}>{zahlung.monatsbetrag}</li>
                ))}
            </ul>
        </div>
    );
}
