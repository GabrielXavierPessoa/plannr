import { serviceCurrency, type Service } from "@/lib/services";
import styles from "./ServiceCard.module.css";

type ServiceCardProps = {
  service: Service;
};

export default function ServiceCard({ service }: ServiceCardProps) {
  return (
    <article className={styles.card}>
      <div
        aria-label={`Foto de ${service.name} será adicionada depois`}
        role="img"
        className={styles.imagePlaceholder}
      >
        <span className={styles.photoPlaceholder}>Foto em breve</span>
      </div>

      <div className={styles.content}>
        <h3 className={styles.name}>{service.name}</h3>
        <p className={styles.description}>{service.description}</p>

        <div className={styles.details}>
          <div>
            <p className={styles.priceLabel}>Preço (exemplo)</p>
            <p className={styles.price}>{serviceCurrency.format(service.price)}</p>
          </div>
          <p className={styles.duration}>{service.durationMinutes} min</p>
        </div>

      </div>
    </article>
  );
}
