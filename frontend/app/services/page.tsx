import ServiceCard from "@/components/ServiceCard";
import Link from "next/link";
import styles from "./services.module.css";

const services = [
  {
    name: "Barbeiro",
    description: "Corte de cabelo e barba com profissional experiente.",
    price: 45,
    durationMinutes: 45,
    illustration: "barber" as const,
  },
  {
    name: "Manicure",
    description: "Tratamento completo para unhas com produtos de qualidade.",
    price: 35,
    durationMinutes: 60,
    illustration: "manicure" as const,
  },
  {
    name: "Massagem",
    description: "Sessão de massagem relaxante para aliviar o estresse.",
    price: 90,
    durationMinutes: 50,
    illustration: "massage" as const,
  },
];

export default function ServicesPage() {
  return (
    <main className={styles.page}>
      <section className={styles.content}>
        <div className={styles.headingRow}>
          <Link
            href="/"
            aria-label="Voltar para a página inicial"
            className={styles.backLink}
          >
            <svg
              aria-hidden="true"
              viewBox="0 0 24 24"
              className={styles.backIcon}
              fill="none"
              stroke="currentColor"
              strokeWidth={2}
              strokeLinecap="round"
              strokeLinejoin="round"
            >
              <path d="M19 12H5" />
              <path d="m12 19-7-7 7-7" />
            </svg>
          </Link>
            <h1 className={styles.title}>
              Nossos serviços
            </h1>
        </div>

        <p className={styles.description}>
          Encontre o serviço ideal para você.
        </p>

        <div className={styles.servicesGrid}>
          {services.map((service) => (
            <ServiceCard key={service.name} service={service} />
          ))}
        </div>
      </section>
    </main>
  );
}
