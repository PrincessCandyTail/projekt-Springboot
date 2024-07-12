
'use client'
import {fetchPolicen} from "@/app/pages/api";

export async function getServerSideProps() {
    const policen = await fetchPolicen();
    return { props: { policen } };
}

export default function Policen({ policen }) {
    return (
        <div>
            <h1>Policen</h1>
            <ul>
                {policen.map((police) => (
                    <li key={police.id}>{police.policenummer}</li>
                ))}
            </ul>
        </div>
    );
}
