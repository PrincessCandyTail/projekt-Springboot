export default function KundenList({ kunden }) {
    return (
        <ul>
            {kunden.map((kunde) => (
                <li key={kunde.id}>{kunde.vorname} {kunde.name}</li>
            ))}
        </ul>
    );
}
