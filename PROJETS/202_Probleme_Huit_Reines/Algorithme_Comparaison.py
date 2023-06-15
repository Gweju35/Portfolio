# Ce code est l'algorithme comparatif
# Ce programme est un algorithme de parcours en profondeur qui permet de résoudre le problème des huit reines 
class Graph:
    def __init__(self):
        """ Initialisation d'un dictionnaire vide qui servira à stocker le graphe """
        self.graph = {}

    def ajouter_bord(self, v, w):
        """ Fonction pour ajouter une arête entre les sommets v et w dans le graphe """
        if v in self.graph:
            # Si v est déjà un sommet dans le graphe, on ajoute w à la liste de ses voisins
            self.graph[v].append(w)
        else:
            # Si v n'est pas encore un sommet dans le graphe, on crée un nouveau sommet avec w comme son seul voisin
            self.graph[v] = [w]

    def estValide(self, v, reine):
        """ Fonction pour vérifier si la position v pour une nouvelle reine est valide, 
            en prenant en compte les positions des reines déjà placées """
        for i, j in enumerate(reine):    # On parcourt les positions de toutes les reines déjà placées
            if v == j or abs(v - j) == len(reine) - i:
                # Si la nouvelle reine est sur la même colonne ou la même diagonale qu'une 
                # autre reine, on retourne False pour indiquer que cette position n'est pas valide
                return False
        # Si la position de la nouvelle reine est valide par rapport à toutes les autres reines, on retourne True
        return True

    def dfs(self, v, n, reine, solutions):
        """ Fonction récursive pour placer les reines sur l'échiquier en explorant 
            toutes les combinaisons possibles à partir d'un sommet v """
        if len(reine) == n:     
            # Si toutes les reines sont placées sur l'échiquier, on ajoute la combinaison
            # actuelle à la liste des solutions et on arrête la récursion
            solutions.append(reine)
            return
        for w in self.graph[v]:     # On explore tous les voisins de v pour placer la prochaine reine
            if self.estValide(w, reine):
                # Si la position w est valide, on crée une nouvelle combinaison de 
                # reines en ajoutant la nouvelle reine w à la fin de la liste reine actuelle
                new_reine = reine + [w]
                # On explore la prochaine combinaison de reines à partir de la position w 
                # en appelant la fonction dfs de manière récursive
                self.dfs(w, n, new_reine, solutions)


def resoudre_probleme_huit_reines(n):
    """ Fonction principale pour résoudre le problème des huit reines sur un échiquier de n x n cases """
    graphe = Graph()
    for i in range(n):
        for j in range(n):
            if i != j:
                # On ajoute toutes les arêtes possibles entre les cases de l'échiquier, sauf celles entre une case et elle-même
                graphe.ajouter_bord(i, j)
    solutions = []
    for i in range(n):
        # On explore toutes les combinaisons de reines possibles à partir de chaque ligne i de l'échiquier
        graphe.dfs(i, n, [i], solutions)
    return solutions


# Exemple d'utilisation :
solutions = resoudre_probleme_huit_reines(8)
i = 0
for solution in solutions:
    print(solution)
# pour les solutions, on part de la ligne 0 (1 sur l'échiquier) et le chiffre donné correspond à la colonne sur la ligne,
# exemple : [0, 4, 7, 5, 2, 6, 1, 3]
# - sur la ligne 0 colonne 0 il y'a une dame
# - sur la ligne 1 colonne 4 il y a une dame 
# - etc 
