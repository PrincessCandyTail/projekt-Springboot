'use client'
import {fetchVersicherungsarten} from "@/app/pages/api";

export async function getServerSideProps() {
    const versicherungsarten = await fetchVersicherungsarten();
    return { props: { versicherungsarten } };
}

export default function Versicherungsarten({ versicherungsarten }) {
    return (
        <div>
            <h1>Versicherungsarten</h1>
            <ul>
                {versicherungsarten.map((art) => (
                    <li key={art.id}>{art.art}</li>
                ))}
            </ul>
        </div>
    );
}
