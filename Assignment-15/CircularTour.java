class CircularTour {
    static class PetrolPump {
        int petrol;
        int distance;
        
        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int tour(PetrolPump[] pumps, int n) {
        int totalSurplus = 0;
        int currentSurplus = 0;
        int start = 0;
        
        for (int i = 0; i < n; i++) {
            totalSurplus += pumps[i].petrol - pumps[i].distance;
            currentSurplus += pumps[i].petrol - pumps[i].distance;
            
            if (currentSurplus < 0) {
                start = i + 1;
                currentSurplus = 0;
            }
        }
        
        return (totalSurplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };
        
        int n = pumps.length;
        int start = tour(pumps, n);
        
        if (start != -1) {
            System.out.println("Start at pump " + start);
        } else {
            System.out.println("No valid starting point");
        }
    }
}
