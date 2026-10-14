import Link from "next/link";
import { notFound } from "next/navigation";
import { getServiceBySlug, serviceCurrency, services } from "@/lib/services";
import styles from "./service-details.module.css";

export function generateStaticParams() {
  return services.map((service) => ({ slug: service.slug }));
}

export default async function ServiceDetailsPage({
  params,
}: {
  params: Promise<{ slug: string }>;
}) {
  const { slug } = await params;
  const service = getServiceBySlug(slug);

  if (!service) notFound();

  return (
    <main className={styles.page}>
      <div className={styles.content}>
        <Link href="/services" className={styles.backLink}>
          <span aria-hidden="true">←</span>
          Voltar para serviços
        </Link>

        <article className={styles.detailCard}>
          <div
            className={styles.photoPlaceholder}
            role="img"
            aria-label={`Espaço reservado para a foto de ${service.name}`}
          >
            <span>Foto do serviço</span>
          </div>

          <div className={styles.details}>
            <p className={styles.eyebrow}>Detalhes do serviço</p>
            <h1 className={styles.title}>{service.name}</h1>
            <p className={styles.description}>{service.description}</p>

            <dl className={styles.facts}>
              <div>
                <dt>Preço (exemplo)</dt>
                <dd>{serviceCurrency.format(service.price)}</dd>
              </div>
              <div>
                <dt>Duração estimada</dt>
                <dd>{service.durationMinutes} minutos</dd>
              </div>
            </dl>

            <p className={styles.note}>
              Preço e duração são apenas exemplos e ainda serão confirmados.
            </p>
          </div>
        </article>
      </div>
    </main>
  );
}
